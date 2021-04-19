import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment';
import { Observable } from 'rxjs';
import { Usuario } from './../entity/usuario';



@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url:string = environment.host + '/users'

  constructor(private http:HttpClient) { }

  public getUserByName(name:string):Observable<Usuario>{
    return this.http.get<Usuario>(this.url + "/"+name)
  }

  public getListFollowersByUser(name:string): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url + "/"+name+"/followers")
  }

  public getListFollowingByUser(name:string): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url + "/"+name+"/following")
  }
}
