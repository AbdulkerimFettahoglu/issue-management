import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators';

@Injectable({
    providedIn: 'root'
})
export class ProjectService {

    private PROJECT_PATH = "/project"
    constructor(private apiService: ApiService) {

    }

    getAll():Observable<any> {
        return this.apiService.get(this.PROJECT_PATH + "/getAll").pipe(map(
            res => {
                if (res) {
                    return res;
                } else {
                    console.log(res);
                    return {};
                }
            }
        ));
    }

    getProject(id):Observable<any> {
        return this.apiService.get(this.PROJECT_PATH + "/get", id).pipe(map(
            res => {
                if (res) {
                    return res;
                } else {
                    console.log(res);
                    return {};
                }
            }
        ));
    }
}