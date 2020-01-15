import { ConnectorService } from './../../services/connector.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-second-comp',
  templateUrl: './second-comp.component.html',
  styleUrls: ['./second-comp.component.css']
})
export class SecondCompComponent implements OnInit {

  data = [];
  constructor(public connector: ConnectorService) {
    this.data = this.connector.get();
 }
 delete(){
   window.alert("This feature is not available yet but will be implemented in next update!");
 }
  ngOnInit() {  }

}
