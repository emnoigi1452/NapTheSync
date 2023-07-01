package me.stella.Back.Main;

import java.util.Date;

public class H1 {
	
	private long t;
	private int p;
	
	public H1(long t, int p) {
		this.t = t;
		this.p = p;
	}
	
	public H1(String h) {
		String[] _p = h.split("b");
		byte[] _b = new byte[_p.length];
		for(int i = 0; i < _p.length; i++)
			_b[i] = Byte.valueOf(_p[i]).byteValue();
		String[] r = (new String(_b)).split("@");
		this.t = Long.valueOf(r[0]).longValue();
		this.p = Integer.valueOf(r[1]).intValue();
	}
	
	public String _c() {
		StringBuilder d = new StringBuilder();
		d.append(String.valueOf(this.t));
		d.append("@");
		d.append(String.valueOf(this.p));
		byte[] _br = d.toString().getBytes();
		StringBuilder bd = new StringBuilder();
		for(byte bv: _br)
			bd.append(String.valueOf(bv).concat("b"));
		return bd.toString();
	}
	
	public long _t_() {
		return this.t;
	}
	
	public Date _td_() {
		return new Date(_t_());
	}
	
	public int _p_() {
		return this.p;
	}

}
