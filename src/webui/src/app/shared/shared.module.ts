import { NgModule } from '@angular/core';
import { ModalModule, BsModalRef } from 'ngx-bootstrap'
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { CommonModule } from "@angular/common";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ModalModule.forRoot()
    ],
    providers: [BsModalRef],
    exports: [
        ModalModule,
        ReactiveFormsModule,
        ConfirmationComponent
    ],
    declarations: [ConfirmationComponent],
    entryComponents: [ConfirmationComponent],
})
export class SharedModule { }
