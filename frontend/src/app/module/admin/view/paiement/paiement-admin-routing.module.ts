
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { PaiementAvoirAchatListAdminComponent } from './paiement-avoir-achat/list/paiement-avoir-achat-list-admin.component';
import { PaiementAvoirVenteListAdminComponent } from './paiement-avoir-vente/list/paiement-avoir-vente-list-admin.component';
import { PaiementVenteListAdminComponent } from './paiement-vente/list/paiement-vente-list-admin.component';
import { PaiementAchatListAdminComponent } from './paiement-achat/list/paiement-achat-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'paiement-avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementAvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementAvoirVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class PaiementAdminRoutingModule { }
