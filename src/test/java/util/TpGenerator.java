package util;

import java.util.Random;

public class TpGenerator {

	public static int getTP(int max,int min){
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
