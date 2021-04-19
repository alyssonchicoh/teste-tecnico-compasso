import { Repository } from './../entity/repository';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {

  private url:string = environment.host + '/users'
  
  constructor(private http:HttpClient) { }

  public getRepositorysByUser(name:string):Observable<Repository[]>{
    return this.http.get<Repository[]>(this.url + "/"+name +"/repos")
  }

  public getRepositoryStarredByUser(name:string):Observable<Repository[]>{
    return this.http.get<Repository[]>(this.url + "/"+name +"/starred")
  }

}
