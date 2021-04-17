package com.selvasankari;

 class CabTypes {
	public static int selectCab(String cabType)
	{
		//validation of cab type which is available or not
		int var=(cabType.equalsIgnoreCase("MICRO") || cabType.equalsIgnoreCase("MINI") || cabType.equalsIgnoreCase("PRIME")) ? 1 :0;
        return var;
	}
}
