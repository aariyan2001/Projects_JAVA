package com.AariyanSahu.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.AariyanSahu.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>(); //Contains all the client sockets
	
	public Server() throws IOException {
		int port = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Start and Waiting for the clients to join");
		handleClientRequest();
		
	}
	
	//Multiple Client Handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = serverSocket.accept(); //Handshaking
			//Per client per thread
			ServerWorker serverworker = new ServerWorker(clientSocket, this);//creating a new worker
			workers.add(serverworker);
			serverworker.start();
		}
	}
	
	/* Single Client
	public Server() throws IOException {
		int port = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Started and waiting for the client connection....");
		Socket socket = serverSocket.accept(); //Handshaking
		System.out.println("Client Joins the Server");
		
		InputStream input = socket.getInputStream(); //read bytes from the network
		byte[] arr = input.readAllBytes();
		String str = new String(arr); //Bytes convert into string
		System.out.println("Message Recieved from the client: "+str);
		input.close();
		socket.close();
	}*/
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Server server = new Server();

	}
}
