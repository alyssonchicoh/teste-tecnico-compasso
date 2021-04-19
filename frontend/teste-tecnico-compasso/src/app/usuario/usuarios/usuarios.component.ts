import { Component, OnInit,ViewChild } from '@angular/core';


import { RepositoryService } from './../../services/repository.service';
import { Repository } from './../../entity/repository';
import { Usuario } from './../../entity/usuario';
import { UsuarioService } from './../../services/usuario.service';
import {ModalDirective} from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  
  @ViewChild('seguidores') 
  public seguidores: ModalDirective;

  @ViewChild('seguindo') 
  public seguindo: ModalDirective;

  public usuario:Usuario;
  public nome:string;
  public repositorys: Repository[]
  public repositorysStarred: Repository[]


  constructor(
    private usuarioService:UsuarioService, 
    private repositoryService: RepositoryService
    ) { }

  ngOnInit(): void {
  }

  consultar(){
    if(this.nome != null){
      this.usuarioService.getUserByName(this.nome).subscribe(
        response =>{
          this.usuario = response;
          this.repositorys = null;
          this.repositorysStarred = null
        },
        error =>{
          this.handleError(error)
        }
      )
    }else{
      alert('Digite um nome')
    }
    
  }

  consultarUsuario(login:string){
    this.nome = login;
    this.consultar()
    this.seguidores.hide()
    this.seguindo.hide()
  }

  consultarRepository(){
    this.repositoryService.getRepositorysByUser(this.nome).subscribe(
      response =>{
        this.repositorys = response;
      },
      error =>{
        if(error.status == 404){
        }else{
          alert('Houve uma falha ao conectar no servidor')

        }
      }
    )
  }

  consultarRepositoryStarred(){
    this.repositoryService.getRepositoryStarredByUser(this.nome).subscribe(
      response =>{
        this.repositorysStarred = response;
        
      },
      error =>{
        alert('Houve uma falha ao conectar no servidor')
      }
    )
  }

  consultarSeguidores(){
    this.usuarioService.getListFollowersByUser(this.nome).subscribe(
      response =>{
        this.usuario.seguidores = response;
        
      },
      error =>{
        this.handleError(error)
      }
    )
  }

  consultarSeguindo(){
    this.usuarioService.getListFollowingByUser(this.nome).subscribe(
      response =>{
        this.usuario.seguindo = response;
        
      },
      error =>{
        this.handleError(error)
      }
    )
  }

  goRepository(url:string){
    window.location.href=url;
  }

  showModalSeguidores(){
    this.consultarSeguidores()
    this.seguidores.show()
  }

  showModalSeguindo(){
    this.consultarSeguindo()
    this.seguindo.show()
  }



  handleError(error: Response) {
    if (error.status == 404) {      
      alert('Usuário nao encontrado')
    } else {
      alert('Houve uma falha ao conectar no servidor')
      return error
    }
}
}
