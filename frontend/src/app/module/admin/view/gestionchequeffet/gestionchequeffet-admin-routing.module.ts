
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ProprietaireListAdminComponent } from './proprietaire/list/proprietaire-list-admin.component';
import { ProprietaireBanqueListAdminComponent } from './proprietaire-banque/list/proprietaire-banque-list-admin.component';
import { TransactionListAdminComponent } from './transaction/list/transaction-list-admin.component';
import { TypeTransactionListAdminComponent } from './type-transaction/list/type-transaction-list-admin.component';
import { CompteListAdminComponent } from './compte/list/compte-list-admin.component';
import { ChequeEffetListAdminComponent } from './cheque-effet/list/cheque-effet-list-admin.component';
import { PermutationListAdminComponent } from './permutation/list/permutation-list-admin.component';
import { PossedeCompteListAdminComponent } from './possede-compte/list/possede-compte-list-admin.component';
import { PermutationItemListAdminComponent } from './permutation-item/list/permutation-item-list-admin.component';
import { TypeInstrumentListAdminComponent } from './type-instrument/list/type-instrument-list-admin.component';
import { BanqueListAdminComponent } from './banque/list/banque-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'proprietaire',
                            children: [
                                {
                                    path: 'list',
                                    component: ProprietaireListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'proprietaire-banque',
                            children: [
                                {
                                    path: 'list',
                                    component: ProprietaireBanqueListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'transaction',
                            children: [
                                {
                                    path: 'list',
                                    component: TransactionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-transaction',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeTransactionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'compte',
                            children: [
                                {
                                    path: 'list',
                                    component: CompteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'cheque-effet',
                            children: [
                                {
                                    path: 'list',
                                    component: ChequeEffetListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'permutation',
                            children: [
                                {
                                    path: 'list',
                                    component: PermutationListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'possede-compte',
                            children: [
                                {
                                    path: 'list',
                                    component: PossedeCompteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'permutation-item',
                            children: [
                                {
                                    path: 'list',
                                    component: PermutationItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-instrument',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeInstrumentListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'banque',
                            children: [
                                {
                                    path: 'list',
                                    component: BanqueListAdminComponent ,
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
export class GestionchequeffetAdminRoutingModule { }
