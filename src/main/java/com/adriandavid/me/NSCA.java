 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

package com.adriandavid.me;

abstract class NSCA {
	protected static NSCA getInstance() { return null; };
	protected abstract NSCA setData (double maxlb, short repnum);
	protected abstract double [] computeMax ();
}