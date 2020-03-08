import { NgModule } from '@angular/core';
import { ModalModule } from 'ngx-bootstrap'
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
    exports: [
        ModalModule,
        ReactiveFormsModule
    ]
})
export class SharedModule { }
