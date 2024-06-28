package com.dacapps.poyectotech.utils.helpers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Util {

	//metodo para comprimir los bytes de la imagen antes de almacenarla en la base de datos
	public static byte[] compressLib(byte[] data) {
		//Se crea un objeto Deflater para comprimir los datos
		Deflater deflater = new Deflater();
		deflater.setInput(data); //Establecer los datos de entrada
		deflater.finish(); //Indicar que se han introducido todos los datos

		//Cra stream de salida para almacenar los datos comprimidos
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024]; //Buffer para leer los datos comprimidos
		while(!deflater.finished()) { //mientras haya datos por comprimir...
			int count = deflater.deflate(buffer); //comprimir los datos y almacenarlos en el buffer
			outputStream.write(buffer, 0, count); //Escribir los datos comprimidos en el stream de salida
		}
		try {
			outputStream.close(); //cerrar el stream de salida
		} catch (IOException e) {

		}
		System.out.println(" Compresion imagen byte tamaño - " + outputStream.toByteArray().length);

		return outputStream.toByteArray(); //devolver los datos comprimidos como un array
	}



	//metodo para descomprimir los bytes de la imagen antes de devolverla al front
	public static byte[] decompressLib(byte[] data){
		//Se crea un objeto Inflater para descomprimir los datos
		Inflater inflater = new Inflater();
		inflater.setInput(data); //Establecer los datos de entrada

		//Cra stream de salida para almacenar los datos descomprimidos
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024]; //Buffer para leer los datos descomprimidos
		try {
			while(!inflater.finished()) { //mientras haya datos por descomprimir...
				int count = inflater.inflate(buffer); //descomprimir los datos y almacenarlos en el buffer
				outputStream.write(buffer, 0, count); //Escribir los datos descomprimidos en el stream de salida
			}
			outputStream.close(); //cerrar el stream de salida
		} catch (IOException e) {

		} catch (DataFormatException e) {
			
		}

		return outputStream.toByteArray(); //devolver los datos comprimidos como un array
	}
}
