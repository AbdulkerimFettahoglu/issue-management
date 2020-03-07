import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectRoutingModule } from './project-routing.module';
import { ProjectComponent } from './project.component';
import { ProjectService } from 'src/app/services/shared/project.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

@NgModule({
  declarations: [ProjectComponent],
  providers: [ProjectService],
  imports: [
    CommonModule,
    NgxDatatableModule,
    ProjectRoutingModule
  ]
})
export class ProjectModule { }
