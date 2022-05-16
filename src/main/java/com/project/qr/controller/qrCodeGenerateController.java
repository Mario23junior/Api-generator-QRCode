package com.project.qr.controller;

import java.io.IOException;

import com.google.zxing.WriterException;
import com.project.qr.service.GenerationQRcode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate/qrcode/")
public class qrCodeGenerateController {

	private GenerationQRcode service;

	public qrCodeGenerateController(GenerationQRcode service) {
		this.service = service;
	}

	private final String PATH_CODE_QRIMAGE = "./src/main/resource/QRCode.png";

	@GetMapping(value = "generat/{width}/{height}/{codeText}")
	public void capturingContentMetricsQrCode(@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width, @PathVariable("height") Integer height)
			throws IOException, WriterException {
		service.geneateQRCodeImageMetrics(codeText, width, height, PATH_CODE_QRIMAGE);
	}

	@GetMapping(value = "/generate/{width}/{height}/{codeText}")
	public ResponseEntity<byte[]> generateQRCode(@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width, @PathVariable("height") Integer height) throws WriterException, IOException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.captureQRCodeImage(codeText, width, height));

	}
}
