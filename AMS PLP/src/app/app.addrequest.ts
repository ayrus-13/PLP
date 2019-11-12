import {Component} from '@angular/core';
import {AssetManagementService} from './_service/app.assetmanagementservice';
import {ActivatedRoute, Router } from '@angular/router';
import {Assets} from 'src/app/_model/app.assets';
import {AllocationRequest} from 'src/app/_model/app.allocationRequest';

@Component({
    selector: 'addrequest',
    templateUrl: 'app.addrequest.html'
})

export class AddRequest {
    assetId:number;
    userId:number;

    allocationRequest:AllocationRequest={allocationId:null,status:"Pending",aQuantity:null,asset:null,user:null};

    ngOnInit(){
        if(sessionStorage.getItem('role')==='user'){
            this.router.navigate(['noauth']);
          }   
    }
    constructor(private service:AssetManagementService,private route: ActivatedRoute, private router:Router){
    }

    addRequest(allocationRequest,ai,ui){
        this.assetId=ai;
        this.userId=ui;
        this.service.addRequest(allocationRequest,ai,ui).subscribe();
        this.router.navigate(['Adding confirmation']);
        alert("Request Added");
        location.reload();
    }

    buttonFlag:boolean=false;
    enableButton(){
        this.buttonFlag=!this.quantityValid&&!this.assetIdValid&&!this.userIdValid;
    }

    quantityValid:boolean=false;
    validateQuantity(){
        if(this.allocationRequest.aQuantity>200){
            this.quantityValid=true;
        }
        else if(this.allocationRequest.aQuantity<1){
            this.quantityValid=true;
        }else{
            this.quantityValid=false;
        }
    }

    assetIdValid:boolean=false;
    validateAId(b:number){
        console
        if(b<=100 || b>=199)
        {
            this.assetIdValid=true;
        }
        else{
            this.assetIdValid=false;
        }
    }

    userIdValid:boolean=false;
    validateUId(a:number){
        if(a<=1000 || a>=1999)
        {
            this.userIdValid=true;
        }
        else{
            this.userIdValid=false;
        }
    }


}
