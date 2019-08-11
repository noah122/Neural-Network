import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Neural {
	private static String filename = "./hw2_midterm_A_train.txt";
	private static ArrayList<Double> readTraining(){
		ArrayList<Double> train = new ArrayList<Double>();
		try{
			File f = new File(filename);
			Scanner sc = new Scanner(f);
			while(sc.hasNextDouble()){
				if(sc.hasNextDouble()){
					double i = sc.nextDouble();
					train.add(i);
				}
				else{
					sc.next();
				}
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("File Not Found.");
		}
		return train;
	}
	private static String filenam = "./hw2_midterm_A_eval.txt";
	private static ArrayList<Double> readEval(){
		ArrayList<Double> eval = new ArrayList<Double>();
		try{
			File f = new File(filenam);
			Scanner sc = new Scanner(f);
			while(sc.hasNextDouble()){
				if(sc.hasNextDouble()){
					double i = sc.nextDouble();
					eval.add(i);
				}
				else{
					sc.next();
				}
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("File Not Found.");
		}
		return eval;
	}
	private static String filena = "./hw2_midterm_A_test.txt";
	private static ArrayList<Double> readTest(){
		ArrayList<Double> test = new ArrayList<Double>();
		try{
			File f = new File(filena);
			Scanner sc = new Scanner(f);
			while(sc.hasNextDouble()){
				if(sc.hasNextDouble()){
					double i = sc.nextDouble();
					test.add(i);
				}
				else{
					sc.next();
				}
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("File Not Found.");
		}
		return test;
	}
	public static void main(String[] args){
		
		DecimalFormat df = new DecimalFormat("0.00000");
		int flag = Integer.valueOf(args[0]);
		double partialEofuA = 0.0;
		double partialEofuB = 0.0;
		double partialEofvB = 0.0;
		double partialEofvA = 0.0;
		double partialEuC = 0.0;
		double partialEvC = 0.0;
		double e = 0.0;
		double partialEw1 = 0.0;
		double partialEw2 = 0.0;
		double partialEw3 = 0.0;
		double partialEw4 = 0.0;
		double partialEw5 = 0.0;
		double partialEw6 = 0.0;
		double partialEw7 = 0.0;
		double partialEw8 = 0.0;
		double partialEw9 = 0.0;
		if(flag == 100)
		{
			ArrayList<Double> eval = readEval();
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double x1 = Double.valueOf(args[10]);
			double x2 = Double.valueOf(args[11]);
			double uOfA = 0.0;
			uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			double uOfB = 0.0;
			double uOfC = 0.0;
			uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double vOfA = 0.0;
			vOfA = Math.max(uOfA, 0);
			double vOfB = 0.0;
			vOfB = Math.max(uOfB, 0);
			uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
			double vOfC = 0.0;
			vOfC = 1 / (1 + Math.exp(-uOfC));
			System.out.println(df.format(uOfA) + " " + df.format(vOfA) + " "  + df.format(uOfB) + " " + df.format(vOfB) + " " + df.format(uOfC) + " " + df.format(vOfC));
		}
		
		else if(flag == 200){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double x1 = Double.valueOf(args[10]);
			double x2 = Double.valueOf(args[11]);
			double y = Double.valueOf(args[12]);
			double uOfA = 0.0;

			uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			double uOfB = 0.0;
			double uOfC = 0.0;
			uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double vOfA = 0.0;
			vOfA = Math.max(uOfA, 0);
			double vOfB = 0.0;
			vOfB = Math.max(uOfB, 0);
			uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
			double vOfC = 0.0;
			vOfC = 1 / (1 + Math.exp(-uOfC));
			e = .5 * Math.pow(vOfC - y, 2);
			partialEvC = vOfC - y;
			partialEuC = partialEvC * (vOfC * (1 - vOfC));
			System.out.println(df.format(e) + " " + df.format(partialEvC) + " " + df.format(partialEuC));
			
		}
		else if(flag == 300){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double x1 = Double.valueOf(args[10]);
			double x2 = Double.valueOf(args[11]);
			double y = Double.valueOf(args[12]);
			double uOfA = 0.0;

			uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			double uOfB = 0.0;
			double uOfC = 0.0;
			uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double vOfA = 0.0;
			vOfA = Math.max(uOfA, 0);
			double vOfB = 0.0;
			vOfB = Math.max(uOfB, 0);
			uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
			double vOfC = 0.0;
			vOfC = 1 / (1 + Math.exp(-uOfC));
			partialEvC = vOfC - y;
			partialEuC = partialEvC * (vOfC * (1 - vOfC));
			partialEofvA = w8 * partialEuC;
			partialEofvB = (w9 * partialEuC);
			if(uOfB >= 0)
			{
				partialEofuB = partialEofvB * 1;
			}
			else{
				partialEofuB = partialEofvB * 0;
			}
			if(uOfA > 0)
			{
				partialEofuA = partialEofvA * 1;
			}
			else{
				partialEofuA = partialEofvA * 0;
			}
			if(partialEofuA == -0.0)
			{
				partialEofuA = 0;
			}
			if(partialEofuB == -0.0)
			{
				partialEofuB = 0.0;
			}
			
			System.out.println(df.format(partialEofvA) + " " + df.format(partialEofuA) + " " + df.format(partialEofvB) + " " + df.format(partialEofuB));
			
		}
		else if(flag == 400){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double x1 = Double.valueOf(args[10]);
			double x2 = Double.valueOf(args[11]);
			double y = Double.valueOf(args[12]);
			double uOfA = 0.0;

			uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			double uOfB = 0.0;
			double uOfC = 0.0;
			uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double vOfA = 0.0;
			vOfA = Math.max(uOfA, 0);
			double vOfB = 0.0;
			vOfB = Math.max(uOfB, 0);
			uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
			double vOfC = 0.0;
			vOfC = 1 / (1 + Math.exp(-uOfC));
			partialEvC = vOfC - y;
			partialEuC = partialEvC * (vOfC * (1 - vOfC));
			partialEofvA = w8 * partialEuC;
			partialEofvB = (w9 * partialEuC);
			if(uOfB >= 0)
			{
				partialEofuB = partialEofvB * 1;
			}
			else{
				partialEofuB = partialEofvB * 0;
			}
			if(uOfA > 0)
			{
				partialEofuA = partialEofvA * 1;
			}
			else{
				partialEofuA = partialEofvA * 0;
			}
			if(partialEofuA == -0.0)
			{
				partialEofuA = 0;
			}
			if(partialEofuB == -0.0)
			{
				partialEofuB = 0.0;
			}
			if(partialEuC == -0.0)
			{
				partialEuC = 0.0;
			}
			partialEw1 = 1 * partialEofuA;
			partialEw2 = x1 * partialEofuA;
			partialEw3 = x2 * partialEofuA;
			partialEw4 = 1 * partialEofuB;
			partialEw5 = x1 * partialEofuB;
			partialEw6 = x2 * partialEofuB;
			partialEw7 = 1 * partialEuC;
			partialEw8 = vOfA * partialEuC;
			partialEw9 = vOfB * partialEuC;
			if(partialEw1 == -0.0)
			{
				partialEw1 = 0.0;
				
			}
			if(partialEw2 == -0.0)
			{
				partialEw2 = 0.0;
				
			}
			if(partialEw3 == -0.0)
			{
				partialEw3 = 0.0;
				
			}
			if(partialEw4 == -0.0)
			{
				partialEw4 = 0.0;
				
			}
			if(partialEw5 == -0.0)
			{
				partialEw5 = 0.0;
				
			}
			if(partialEw6 == -0.0)
			{
				partialEw6 = 0.0;
				
			}
			if(partialEw7 == -0.0)
			{
				partialEw7 = 0.0;
				
			}
			if(partialEw8 == -0.0)
			{
				partialEw8 = 0.0;
				
			}
			if(partialEw9 == -0.0)
			{
				partialEw9 = 0.0;
				
			}
			System.out.println(df.format(partialEw1) + " " + df.format(partialEw2) + " " + df.format(partialEw3) + " " + df.format(partialEw4) + " " + df.format(partialEw5) + " " + df.format(partialEw6) + " " + df.format(partialEw7) + " " + df.format(partialEw8) + " " + df.format(partialEw9));
			
			
			
		}
		else if(flag == 500){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double x1 = Double.valueOf(args[10]);
			double x2 = Double.valueOf(args[11]);
			double y = Double.valueOf(args[12]);
			double n = Double.valueOf(args[13]);
			double uOfA = 0.0;
			uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			double uOfB = 0.0;
			double uOfC = 0.0;
			uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double vOfA = 0.0;
			vOfA = Math.max(uOfA, 0);
			double vOfB = 0.0;
			vOfB = Math.max(uOfB, 0);
			uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
			double vOfC = 0.0;
			vOfC = 1 / (1 + Math.exp(-uOfC));
			partialEvC = vOfC - y;
			partialEuC = partialEvC * (vOfC * (1 - vOfC));
			partialEofvA = w8 * partialEuC;
			partialEofvB = (w9 * partialEuC);
			if(uOfB >= 0)
			{
				partialEofuB = partialEofvB * 1;
			}
			else{
				partialEofuB = partialEofvB * 0;
			}
			if(uOfA > 0)
			{
				partialEofuA = partialEofvA * 1;
			}
			else{
				partialEofuA = partialEofvA * 0;
			}
			if(partialEofuA == -0.0)
			{
				partialEofuA = 0;
			}
			if(partialEofuB == -0.0)
			{
				partialEofuB = 0.0;
			}
			if(partialEuC == -0.0)
			{
				partialEuC = 0.0;
			}
			
			
			e = .5 * Math.pow(vOfC - y, 2);
			System.out.println(df.format(w1) + " " + df.format(w2) + " " + df.format(w3) + " " + df.format(w4) + " " + df.format(w5) + " " + df.format(w6) + " " + df.format(w7) + " " + df.format(w8) + " " + df.format(w9));
			System.out.println(df.format(e));
			partialEw1 = 1 * partialEofuA;
			partialEw2 = x1 * partialEofuA;
			partialEw3 = x2 * partialEofuA;
			partialEw4 = 1 * partialEofuB;
			partialEw5 = x1 * partialEofuB;
			partialEw6 = x2 * partialEofuB;
			partialEw7 = 1 * partialEuC;
			partialEw8 = vOfA * partialEuC;
			partialEw9 = vOfB * partialEuC;			
			w1 = w1 - (n * partialEw1);
			w2 = w2 - (n * partialEw2);
			w3 = w3 - (n * partialEw3);
			w4 = w4 - (n * partialEw4);
			w5 = w5 - (n * partialEw5);
			w6 = w6 - (n * partialEw6);
			w7 = w7 - (n * partialEw7);
			w8 = w8 - (n * partialEw8);
			w9 = w9 - (n * partialEw9);
			System.out.println(df.format(w1) + " " + df.format(w2) + " " + df.format(w3) + " " + df.format(w4) + " " + df.format(w5) + " " + df.format(w6) + " " + df.format(w7) + " " + df.format(w8) + " " + df.format(w9));
			double NewUofA = 0.0;
			double NewUofB = 0.0;
			double NewUofC = 0.0;
			NewUofA = (w1 * 1) + (w2 * x1) + (w3 * x2);
			NewUofB = (w4 * 1) + (w6 * x2) + (w5 * x1);
			double NewVofA = 0.0;
			double NewVofB = 0.0;
			double NewVofC = 0.0;
			NewVofA = Math.max(NewUofA, 0);
			NewVofB = Math.max(NewUofB, 0);
			NewUofC = (w7 * 1) + (w8 * NewVofA) + (w9 * NewVofB);
			NewVofC = 1 / (1 + Math.exp(-NewUofC));
			double NewE = 0.0;
			NewE = .5 * Math.pow(NewVofC - y, 2);
			System.out.println(df.format(NewE));
			


		}
		else if(flag == 600){
			ArrayList<Double> train = readTraining();
			ArrayList<Double> eval = readEval();
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double n = Double.valueOf(args[10]);
			double vOfC = 0.0;
			double uOfC = 0.0;
			double vOfA = 0.0;
			double vOfB = 0.0;
			double uOfA = 0.0;
			double uOfB = 0.0;
			double x1 = 0.0;
			double x2 = 0.0;
			double y = 0.0;

			for(int i = 0; i < train.size() / 3; i++)
			{
				double error = 0.0;
				System.out.println(df.format(train.get(i * 3)) + " " + df.format(train.get(i * 3 + 1)) + " " + df.format(train.get(i * 3 + 2)));
				x1 = train.get(i * 3);
				x2 = train.get(i * 3 + 1);
				y = train.get(i * 3 + 2);
				uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
				uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
				vOfA = Math.max(uOfA, 0);
				vOfB = Math.max(uOfB, 0);
				uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
				vOfC = 1 / (1 + Math.exp(-uOfC));
				partialEvC = vOfC - y;
				partialEuC = partialEvC * (vOfC * (1 - vOfC));
				partialEofvA = w8 * partialEuC;
				partialEofvB = (w9 * partialEuC);
				if(uOfB >= 0)
				{
					partialEofuB = partialEofvB * 1;
				}
				else{
					partialEofuB = partialEofvB * 0;
				}
				if(uOfA > 0)
				{
					partialEofuA = partialEofvA * 1;
				}
				else{
					partialEofuA = partialEofvA * 0;
				}
				if(partialEofuA == -0.0)
				{
					partialEofuA = 0;
				}
				if(partialEofuB == -0.0)
				{
					partialEofuB = 0.0;
				}
				partialEw1 = 1 * partialEofuA;
				partialEw2 = x1 * partialEofuA;
				partialEw3 = x2 * partialEofuA;
				partialEw4 = 1 * partialEofuB;
				partialEw5 = x1 * partialEofuB;
				partialEw6 = x2 * partialEofuB;
				partialEw7 = 1 * partialEuC;
				partialEw8 = vOfA * partialEuC;
				partialEw9 = vOfB * partialEuC;
				w1 = w1 - (n * partialEw1);
				w2 = w2 - (n * partialEw2);
				w3 = w3 - (n * partialEw3);
				w4 = w4 - (n * partialEw4);
				w5 = w5 - (n * partialEw5);
				w6 = w6 - (n * partialEw6);
				w7 = w7 - (n * partialEw7);
				w8 = w8 - (n * partialEw8);
				w9 = w9 - (n * partialEw9);
				System.out.println(df.format(w1) + " " + df.format(w2) + " " + df.format(w3) + " " + df.format(w4) + " " + df.format(w5) + " " + df.format(w6) + " " + df.format(w7) + " " + df.format(w8) + " " + df.format(w9));				
				for(int j = 0; j < eval.size()/3; j++)
				{
					double x1k = 0.0;
					double x2k = 0.0;
					double yk = 0.0;
					x1k = eval.get(j*3);
					x2k = eval.get(j*3 + 1);
					yk = eval.get(j*3 + 2);
					uOfA = ((w1 * 1) + (w2 * x1k) + (w3 * x2k)); 
					uOfB = (w4 * 1) + (w6 * x2k) + (w5 * x1k);
					vOfA = Math.max(uOfA, 0.0);
					vOfB = Math.max(uOfB, 0.0);
					uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
					vOfC = 1 / (1 + Math.exp(-uOfC));
					error += .5 * Math.pow((vOfC - yk), 2);
				}
				System.out.println(df.format(error));
			}
			
		}
		
		else if(flag == 700){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double n = Double.valueOf(args[10]);
			double t = Double.valueOf(args[11]);
			ArrayList<Double> train = readTraining();
			ArrayList<Double> eval = readEval();
			double x1 = 0.0;
			double x2 = 0.0;
			double y = 0.0;
			double vOfC = 0.0;
			double uOfC = 0.0;
			double vOfA = 0.0;
			double vOfB = 0.0;
			double uOfA = 0.0;
			double uOfB = 0.0;
			double error  = 0.0;
			for(int k = 0; k < t; k++)
			{
				for(int i = 0; i < train.size() / 3; i++)
				{
					x1 = train.get(i * 3);
					x2 = train.get(i * 3 + 1);
					y = train.get(i * 3 + 2);
					uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
					uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
					vOfA = Math.max(uOfA, 0);
					vOfB = Math.max(uOfB, 0);
					uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
					vOfC = 1 / (1 + Math.exp(-uOfC));
					partialEvC = vOfC - y;
					partialEuC = partialEvC * (vOfC * (1 - vOfC));
					partialEofvA = w8 * partialEuC;
					partialEofvB = (w9 * partialEuC);
					if(uOfB >= 0)
					{
						partialEofuB = partialEofvB * 1;
					}
					else{
						partialEofuB = partialEofvB * 0;
					}
					if(uOfA > 0)
					{
						partialEofuA = partialEofvA * 1;
					}
					else{
						partialEofuA = partialEofvA * 0;
					}
					if(partialEofuA == -0.0)
					{
						partialEofuA = 0;
					}
					if(partialEofuB == -0.0)
					{
						partialEofuB = 0.0;
					}
					partialEw1 = 1 * partialEofuA;
					partialEw2 = x1 * partialEofuA;
					partialEw3 = x2 * partialEofuA;
					partialEw4 = 1 * partialEofuB;
					partialEw5 = x1 * partialEofuB;
					partialEw6 = x2 * partialEofuB;
					partialEw7 = 1 * partialEuC;
					partialEw8 = vOfA * partialEuC;
					partialEw9 = vOfB * partialEuC;
					w1 = w1 - (n * partialEw1);
					w2 = w2 - (n * partialEw2);
					w3 = w3 - (n * partialEw3);
					w4 = w4 - (n * partialEw4);
					w5 = w5 - (n * partialEw5);
					w6 = w6 - (n * partialEw6);
					w7 = w7 - (n * partialEw7);
					w8 = w8 - (n * partialEw8);
					w9 = w9 - (n * partialEw9);
					error = 0;
					for(int j = 0; j < eval.size()/3; j++)
					{
						double x1k = 0.0;
						double x2k = 0.0;
						double yk = 0.0;
						x1k = eval.get(j*3);
						x2k = eval.get(j*3 + 1);
						yk = eval.get(j*3 + 2);
						uOfA = ((w1 * 1) + (w2 * x1k) + (w3 * x2k)); 
						uOfB = (w4 * 1) + (w6 * x2k) + (w5 * x1k);
						vOfA = Math.max(uOfA, 0.0);
						vOfB = Math.max(uOfB, 0.0);
						uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
						vOfC = 1 / (1 + Math.exp(-uOfC));
						error += .5 * Math.pow((vOfC - yk), 2);
					}
					
				}
				System.out.println(df.format(w1) + " " + df.format(w2) + " " + df.format(w3) + " " + df.format(w4) + " " + df.format(w5) + " " + df.format(w6) + " " + df.format(w7) + " " + df.format(w8) + " " + df.format(w9));				

				System.out.println(df.format(error));
			}
			
		}
		else if(flag == 800){
			double w1 = Double.valueOf(args[1]);
			double w2 = Double.valueOf(args[2]);
			double w3 = Double.valueOf(args[3]);
			double w4 = Double.valueOf(args[4]);
			double w5 = Double.valueOf(args[5]);
			double w6 = Double.valueOf(args[6]);
			double w7 = Double.valueOf(args[7]);
			double w8 = Double.valueOf(args[8]);
			double w9 = Double.valueOf(args[9]);
			double n = Double.valueOf(args[10]);
			int  t = Integer.valueOf(args[11]);
			ArrayList<Double> train = readTraining();
			ArrayList<Double> eval = readEval();
			ArrayList<Double> test = readTest();
			double x1 = 0.0;
			double x2 = 0.0;
			double y = 0.0;
			double vOfC = 0.0;
			double uOfC = 0.0;
			double vOfA = 0.0;
			double vOfB = 0.0;
			double uOfA = 0.0;
			double uOfB = 0.0;
			double error  = 0.0;
			double temp = 1000000000;
			int count = 0;
			double count1 = 0;
			int temp1 = 0;
			for(int k = 0; k < t; k++)
			{
				count++;
					for(int i = 0; i < train.size() / 3; i++)
					{
						
						x1 = train.get(i * 3);
						x2 = train.get(i * 3 + 1);
						y = train.get(i * 3 + 2);
						uOfA = (w1 * 1) + (w2 * x1) + (w3 * x2);
						uOfB = (w4 * 1) + (w6 * x2) + (w5 * x1);
						vOfA = Math.max(uOfA, 0);
						vOfB = Math.max(uOfB, 0);
						uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
						vOfC = 1 / (1 + Math.exp(-uOfC));
						partialEvC = vOfC - y;
						partialEuC = partialEvC * (vOfC * (1 - vOfC));
						partialEofvA = w8 * partialEuC;
						partialEofvB = (w9 * partialEuC);
						if(uOfB >= 0)
						{
							partialEofuB = partialEofvB * 1;
						}
						else{
							partialEofuB = partialEofvB * 0;
						}
						if(uOfA > 0)
						{
							partialEofuA = partialEofvA * 1;
						}
						else{
							partialEofuA = partialEofvA * 0;
						}
						if(partialEofuA == -0.0)
						{
							partialEofuA = 0;
						}
						if(partialEofuB == -0.0)
						{
							partialEofuB = 0.0;
						}
						partialEw1 = 1 * partialEofuA;
						partialEw2 = x1 * partialEofuA;
						partialEw3 = x2 * partialEofuA;
						partialEw4 = 1 * partialEofuB;
						partialEw5 = x1 * partialEofuB;
						partialEw6 = x2 * partialEofuB;
						partialEw7 = 1 * partialEuC;
						partialEw8 = vOfA * partialEuC;
						partialEw9 = vOfB * partialEuC;
						w1 = w1 - (n * partialEw1);
						w2 = w2 - (n * partialEw2);
						w3 = w3 - (n * partialEw3);
						w4 = w4 - (n * partialEw4);
						w5 = w5 - (n * partialEw5);
						w6 = w6 - (n * partialEw6);
						w7 = w7 - (n * partialEw7);
						w8 = w8 - (n * partialEw8);
						w9 = w9 - (n * partialEw9);
						error = 0;
						for(int j = 0; j < eval.size()/3; j++)
						{
							double x1k = 0.0;
							double x2k = 0.0;
							double yk = 0.0;
							x1k = eval.get(j*3);
							x2k = eval.get(j*3 + 1);
							yk = eval.get(j*3 + 2);
							uOfA = ((w1 * 1) + (w2 * x1k) + (w3 * x2k)); 
							uOfB = (w4 * 1) + (w6 * x2k) + (w5 * x1k);
							vOfA = Math.max(uOfA, 0.0);
							vOfB = Math.max(uOfB, 0.0);
							uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
							vOfC = 1 / (1 + Math.exp(-uOfC));
							error += .5 * Math.pow((vOfC - yk), 2);
							
						}
						
						
					}
					
					
					if(error > temp)
					{
						
						break;
					}
					else{
						temp = error;
						
					}
					
				}
			for(int b = 0; b < test.size() / 3; b++)
			{
				double x1k = 0.0;
				double x2k = 0.0;
				double yk = 0.0;
				x1k = test.get(b * 3);
				x2k = test.get(b * 3 + 1);
				yk = test.get(b * 3 + 2);
				uOfA = ((w1 * 1) + (w2 * x1k) + (w3 * x2k)); 
				uOfB = (w4 * 1) + (w6 * x2k) + (w5 * x1k);
				vOfA = Math.max(uOfA, 0.0);
				vOfB = Math.max(uOfB, 0.0);
				uOfC = (w7 * 1) + (w8 * vOfA) + (w9 * vOfB);
				vOfC = 1 / (1 + Math.exp(-uOfC));
				if((yk == 1 && vOfC >= .5) || (yk == 0 && vOfC <= .5))
				{
					count1++;
					
				}
			}
			System.out.println(count);
			System.out.println(df.format(w1) + " " + df.format(w2) + " " + df.format(w3) + " " + df.format(w4) + " " + df.format(w5) + " " + df.format(w6) + " " + df.format(w7) + " " + df.format(w8) + " " + df.format(w9));				
			System.out.println(df.format(error));
			System.out.println(df.format(count1 / ( 25)));

			}
			
			

		}
	}
