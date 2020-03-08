import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams, } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { catchError } from 'rxjs/operators/catchError';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  
  constructor(private http: HttpClient) { }
  
  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + path, {params}).pipe(catchError(this.formatError));
  }

  private formatError(error: any) {
    return Observable.of(environment.API_BASE_PATH + error.error);
  }

  post(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.post(environment.API_BASE_PATH + path, JSON.stringify(params), this.httpOptions).pipe(catchError(this.formatError));
  }
}
