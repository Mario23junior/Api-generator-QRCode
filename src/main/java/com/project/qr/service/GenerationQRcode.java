package com.project.qr.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.stereotype.Service;

@Service
public class GenerationQRcode {
   
	String format = "PNG";
	public void geneateQRCodeImageMetrics(String text, Integer width, Integer height, String filePath) throws IOException, WriterException {
		QRCodeWriter qrgenerate = new QRCodeWriter();
		BitMatrix bitMatrix = qrgenerate.encode(text, BarcodeFormat.QR_CODE, width, height);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, format, path);
	}
	
	public byte[] captureQRCodeImage(String text,Integer width,Integer height) throws WriterException, IOException {
		QRCodeWriter qrCodeWrite = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWrite.encode(text, BarcodeFormat.QR_CODE, width, height);
		
		ByteArrayOutputStream pngOutStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, format, pngOutStream);
		byte[] pngDate = pngOutStream.toByteArray();
		return pngDate;
	}
}
