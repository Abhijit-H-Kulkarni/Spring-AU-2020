import { ConnectorService } from './../../services/connector.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-first-comp',
  templateUrl: './first-comp.component.html',
  styleUrls: ['./first-comp.component.css']
})
export class FirstCompComponent implements OnInit {

  constructor(public connector: ConnectorService) { }

  infoForm = new FormGroup({
    fname : new FormControl(''),
    lname : new FormControl(''),
    email : new FormControl('')
  });

  ngOnInit() {
  }

  send() {
    this.connector.set(this.infoForm.value.fname, this.infoForm.value.lname, this.infoForm.value.email);
    window.alert('Information submitted successfully.');
    }

}
