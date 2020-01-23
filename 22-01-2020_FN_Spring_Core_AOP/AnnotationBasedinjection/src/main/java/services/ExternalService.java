package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Point;

@Service
public class ExternalService {
	@Autowired
	Point p1;
	
	public void getDetails() {
		p1.Display();
	}

}
