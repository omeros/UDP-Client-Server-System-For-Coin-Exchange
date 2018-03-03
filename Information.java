package maman16targil2;

import java.io.Serializable;

public class Information implements Serializable
{
	String _source;
	String _target;
	int _amount;
	int _verification;
	
	public Information(String source, String target, int amount, int verification  )
	{
		_source=source;
		_target=target;
		_amount=amount;
		_verification=verification;
	}

	public String get_source() {
		return _source;
	}

	public void set_source(String _source) {
		this._source = _source;
	}

	public String get_target() {
		return _target;
	}

	public void set_target(String _target) {
		this._target = _target;
	}

	public int get_amount() {
		return _amount;
	}

	public void set_amount(int _amount) {
		this._amount = _amount;
	}
	
	public String toString()
	{
		String s=_source +" ," +_target + " , "+ _amount;
		return s;
	}

	public int get_verification() {
		return _verification;
	}

	public void set_verification(int _verification) {
		this._verification = _verification;
	}

}
