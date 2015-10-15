package manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Hospital;
import thread.MyThread;

public class ManagerJson extends MyThread{

	private Hospital hospital;
	
	public ManagerJson(String url) {
		super(url);
	}

	@Override
	public void run() {
		Parsing();
	}

	@Override
	public void Parsing() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		hospital = gson.fromJson(this.UrlConnection(), Hospital.class);
	}

	public Hospital getHospital() {
		return hospital;
	}
}
