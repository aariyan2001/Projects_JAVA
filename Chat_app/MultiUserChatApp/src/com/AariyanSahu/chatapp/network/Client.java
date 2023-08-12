package com.AariyanSahu.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.AariyanSahu.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker clientWorker;
	JTextArea textArea;
	
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int port = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"),port);
		out = socket.getOutputStream();
		in= socket.getInputStream();
		this.textArea = textArea;
		readMessages();
		
		/*System.out.println("Client comes.....");
		System.out.println("Enter the message send to the server....");
		
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		OutputStream out = socket.getOutputStream();
		out.write(message.getBytes()); //write bytes on network
		System.out.println("Message send to server");
		in.close();
		out.close();
		socket.close();
		 * */
	}
	
	public void sendMessage(String message) throws IOException {
		message = message+"\n";
		out.write(message.getBytes());
	}
	
	public void readMessages() {
		clientWorker = new ClientWorker(in, textArea);  //calling a read thread
		clientWorker.start();
		
	}
	/*
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
	}
	*/

}
