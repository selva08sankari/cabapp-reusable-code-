package com.selvasankari;

 class CabTypes {
	public static boolean selectCab(String cabType)
	{
		//validation of cab type which is available or not
		if(cabType.equalsIgnoreCase("MICRO") || cabType.equalsIgnoreCase("MINI") || cabType.equalsIgnoreCase("PRIME"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
