package edu.isistan.uima.unified.ruta;

public class SentenceMark {
	private int begin;
	private int end;
	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}
	/**
	 * @param begin the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}
	public SentenceMark(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

}
