import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

declare var $: any;
@Injectable({
  providedIn: 'root'
})
export class HttpservicesService 
{
    private TOKEN_KEY = 'auth-token';
  savedToast: any = {};
    toastPosition = "";
    toastType = "";

  constructor(private http: HttpClient) 
  { 

  }

  public get<T>(url: string): Observable<T> 
  {
    return this.http.get<T>(url);
  }

  public postdata<T>(url: string, data: any): Observable<T> 
  {
    return this.http.post<T>(url,data);
  }

  public update<T>(url: string, data: any): Observable<T> 
  {
    return this.http.put<T>(url,data);
  }

      ShowToasts(title: string, subtitle: string, message: string, type: string) 
        {
            let iconName = ""
            console.log("Helloooo")
            //  let currentUserDetail = JSON.parse(localStorage.getItem("userDetails"));
            //  let currentConfigDetail = JSON.parse(localStorage.getItem("themeConfig"));
            if (type == "Success") {
                this.toastType = "bg-success";
                iconName = "fas fa-info-circle";
            } else if (type == "Info") {
                this.toastType = "bg-info";
                iconName = "fas fa-info-circle";
            } else if (type == "Warning") {
                this.toastType = "bg-warning";
                iconName = "fas fa-exclamation-circle";
            }
            else if (type == "Danger") {
                this.toastType = "bg-danger";
                iconName = "fas fa-exclamation-triangle";
            }
            if (this.savedToast.position != undefined) {
                if (this.savedToast.position == "TL") {
                    this.toastPosition = "topLeft";
                } else if (this.savedToast.position == "TR") {
                    this.toastPosition = "topRight";
                } else if (this.savedToast.position == "BL") {
                    this.toastPosition = "bottomLeft";
                }
                else if (this.savedToast.position == "BR") {
                    this.toastPosition = "bottomRight";
                }
                else if (this.savedToast.position == "TC") {
                    this.toastPosition = "topCenter";
                }
                else if (this.savedToast.position == "BC") {
                    this.toastPosition = "bottomCenter";
                }
            } else {
                this.toastPosition = "topCenter";
            }


            $(document).Toasts('create', {
                class: this.toastType,
                title: message,
                subtitle: '',
                position: this.toastPosition,
                icon: iconName,
                autohide: true,
                delay: 5000,
            })
            return 1;
        }

        getToken(): string | null 
        {
          return localStorage.getItem(this.TOKEN_KEY);
        } //gettoken ends here *************************************************

        setToken(token: string): void 
        {
          localStorage.setItem(this.TOKEN_KEY, token);
        } //set token ends here ***********************************************
        removeToken(): void 
        {
          localStorage.removeItem(this.TOKEN_KEY);
        } //remove token ends here *********************************************

}
