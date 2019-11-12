import { User } from "./app.user";
import { Assets } from "./app.assets";



export class AllocationRequest{
    allocationId: number;
    aQuantity:number;
    status:string;
    user:User;
    asset:Assets;
}