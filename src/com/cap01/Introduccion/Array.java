package com.cap01.Introduccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class countValues{
	public Integer[] countItems(String[] arr){
		List<Integer> itemCount = new ArrayList<Integer>();
		Integer counter = 0;
	    String lastItem = arr[0];
		
	    for(int i = 0; i < arr.length; i++){
	        if(arr[i].equals(lastItem)){
	            counter++;
	        }else{
	            itemCount.add(counter);
	            counter = 1;
	        }
	        lastItem = arr[i];
	    }
	    itemCount.add(counter);

	    return itemCount.toArray(new Integer[itemCount.size()]);
	}
}


public class Array{
	
	public static void main(String[] args){
		String[] array = {"A", "B", "A", "C", "B", "C", "C"};
		
		Arrays.sort(array);
		
		countValues myCount = new countValues();
		
		Integer[] cArr = myCount.countItems(array);
		
		int num = 0;
	    for(int i = 0; i < cArr.length; i++)
	    {
	        num += cArr[i]-1;
	        System.out.println(array[num] + ": " + cArr[i].toString());
	    }
	}
}
