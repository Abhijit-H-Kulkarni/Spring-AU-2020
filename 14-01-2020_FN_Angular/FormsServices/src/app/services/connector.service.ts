import { Injectable } from '@angular/core';

@Injectable()
export class ConnectorService {
  data = [];
  i = 0;
  set(fname, lname, email) {
    this.data[this.i] = new Array(fname, lname, email);
    this.i++;
  }

  get() {
    return this.data;
  }
  constructor() { }
}
