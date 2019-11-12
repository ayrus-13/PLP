import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { AllocationRequest } from '../_model/app.allocationRequest';
//import {User} from './_model/app.user';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})

export class AssetManagementService{
    //user:User;
    temp:any;

    //Dependency Injection
    constructor(private myhttp:HttpClient){}

    showAssets(){
        return this.myhttp.get('http://localhost:9088/showassets');
    }

    addAsset(data:any){
        //For RequestBody
        //return this.myhttp.post('http://localhost:9088/product/add',data);
        console.log(data);
        //For Model Attribute
        let form=new FormData();
        form.append("assetId", String(data.assetId));
        form.append("assetName", data.assetName);
        form.append("quantity", String(data.quantity));
        return this.myhttp.post('http://localhost:9088/add', form);
    }

    deleteAsset(id:number){ 
        return this.myhttp.delete("http://localhost:9088/deleteasset?assetId="+id);
    }

    searchAsset(id:number){
        return this.myhttp.get('http://localhost:9088/searchasset?assetId='+id);
    }

    updateAsset(data:any){
        return this.myhttp.put('http://localhost:9088/modifyasset',data);
    }

    addRequest(allocationRequest:AllocationRequest,userId,assetId){
        let form=new FormData();
        form.append("status",String(allocationRequest.status));
        form.append("aQuantity",String(allocationRequest.aQuantity));

        let params = new HttpParams()
        .set('userId',userId)
        .set('assetId',assetId);

        console.log(params.toString());
        

        return this.myhttp.post('http://localhost:9088/addRequest?',form,{params}); 
    }

    showRequests(){
        return this.myhttp.get('http://localhost:9088/getRequests');
    }

    approveRequest(id:number){
        return this.myhttp.post('http://localhost:9088/approveRequest?allocationId='+id,{});
    }

    rejectRequest(id:number){
        return this.myhttp.post('http://localhost:9088/rejectRequest?allocationId='+id,{});
    }

    loginUser(empId : string, password : string):Observable<any>{
        //let form = new FormData();
        //form.append("empId",empId);
        //form.append("password",password);
        console.log("in service angular");
    
        return this.myhttp.get('http://localhost:9088/login/?userId="+userId+"&userPassword="+userPassword');
      }

    //   saveUser(user : User){
    //     console.log("saving user");
    //     this.user = user;
    //     console.log(user);
    //     console.log(sessionStorage);
        
    //   }

}