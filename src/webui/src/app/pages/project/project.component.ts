import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/services/shared/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.getAll().subscribe(
      (resp) => {
        console.log(resp);
      }
    );
  }

}
