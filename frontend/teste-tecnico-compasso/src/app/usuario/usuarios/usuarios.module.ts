import { FormsModule } from '@angular/forms';
import { UsuarioRoutingModule } from './usuario-routing.module';
import { UsuariosComponent } from './usuarios.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalModule } from 'ngx-bootstrap/modal';


@NgModule({
  declarations: [UsuariosComponent],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    FormsModule,
    ModalModule.forRoot()

  ]
})
export class UsuariosModule { }
