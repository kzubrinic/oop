package DoD;

public abstract class Medij  {
	private boolean prazan;
	private boolean rw;
	
	public boolean isPrazan() {
		return prazan;
	}
	public void setPrazan(boolean prazan) {
		this.prazan = prazan;
	}
	public boolean isRw() {
		return rw;
	}
	public void setRw(boolean rw) {
		this.rw = rw;
	}
	public abstract boolean pecenjeDiska();
}