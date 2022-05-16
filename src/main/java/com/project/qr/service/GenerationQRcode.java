package com.project.qr.service;

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
	public void geneateQRCodeImage(String text, Integer width,Integer height, String filePath) throws IOException, WriterException {
		QRCodeWriter qrgenerate = new QRCodeWriter();
		BitMatrix bitMatrix = qrgenerate.encode(filePath, BarcodeFormat.QR_CODE, width, height);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, format, path);
	}
}
