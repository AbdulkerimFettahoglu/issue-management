import { Component, OnInit, TemplateRef } from '@angular/core';
import { ProjectService } from 'src/app/services/shared/project.service';
import { Page } from 'src/app/common/page';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ConfirmationComponent} from '../../shared/confirmation/confirmation.component';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  modalRef: BsModalRef;
  projectForm: FormGroup;

  page = new Page();
  cols = [];
  rows = [];

  constructor(private projectService: ProjectService, private modalService: BsModalService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.cols = [
      {prop:'id',name:'No'},
      {prop:'projectName',name:'Project Name',sortable:false},
      {prop:'projectCode', name:'Project Code',sortable:false}];
    this.setPage({ offset: 0 });
    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]]
    });
  }

   /**
   * Populate the table with new data based on the page number
   * @param page The page to select
   */
  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }

  saveProject() {
    if(!this.projectForm.valid)
      return;

    this.projectService.createProject(this.projectForm.value).subscribe(
      response => {
        console.log(response);
      }
    )
    this.setPage({ offset: 0 });
    this.closeAndResetModal();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  get f() { return this.projectForm.controls }

  closeAndResetModal(){
    this.projectForm.reset();
    this.modalRef.hide();
  }

  showDeleteConfirmation() : void{
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Test Header Content',
      'Test Body Content'
    );

    (<ConfirmationComponent>modal.content).onClose.subscribe( result=>{
     if(result===true){
      console.log("Yes")
     } else if(result===false){
       console.log("No")
     }}
    );
  }
}
