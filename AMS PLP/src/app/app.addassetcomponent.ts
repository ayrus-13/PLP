import {Component} from '@angular/core';
import {AssetManagementService} from './_service/app.assetmanagementservice';
import { Router } from '@angular/router';
import {Assets} from 'src/app/_model/app.assets';
import { ResourceLoader } from '@angular/compiler';

@Component({
    selector: 'asset',
    templateUrl: 'app.addasset.html'
})

export class AddAssetComponent {
    asset:Assets;
    model:Assets;

    ngOnInit() {
          this.asset = new Assets();
          this.model = new Assets();   
        }
  

    constructor(private service:AssetManagementService, private router:Router){}       

    addAsset():any{
        this.service.addAsset(this.asset).subscribe((data)=>console.log(data));
        alert("Asset added");
        location.reload();
        //this.router.navigate(['/show']);
    }
    buttonFlag:boolean=false;
    enableButton(){
        this.buttonFlag=!this.idValid&&!this.nameValid&&!this.quantityValid;
    }
    idValid:boolean=false;
    validateId(){
        if(this.asset.assetId>999){
            this.idValid=true;
        }
        else if(this.asset.assetId<1){
            this.idValid=true;
        }else{
            this.idValid=false;
        }
    }
    nameValid:boolean=false;
    validateName(){
        if(this.asset.assetName.length>20){
            this.nameValid=true;
        }else if(this.asset.assetName.length<3){
            this.nameValid=true;
        }else{
            this.nameValid=false;
        }
    }
    quantityValid:boolean=false;
    validateQuantity(){
        if(this.asset.quantity>200){
            this.quantityValid=true;
        }else{
            this.quantityValid=false;
        }
    }

}