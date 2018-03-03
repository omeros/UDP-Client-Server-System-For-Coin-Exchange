package maman16targil2;

import java.io.Serializable;

public class ReturnAnswer implements Serializable
{
	double _answer;
	int _verificationl;
	
	public ReturnAnswer( double answer, int verificationl )
	{
		_answer=answer;
		_verificationl=verificationl;
	}

	public double get_answer() {
		return _answer;
	}

	public void set_answer(double _answer) {
		this._answer = _answer;
	}

	public int get_verificationl() {
		return _verificationl;
	}

	public void set_verificationl(int _verificationl) {
		this._verificationl = _verificationl;
	}

}
