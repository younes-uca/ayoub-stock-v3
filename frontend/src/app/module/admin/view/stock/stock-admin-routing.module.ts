
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { AvoirVenteItemListAdminComponent } from './avoir-vente-item/list/avoir-vente-item-list-admin.component';
import { AvoirVenteListAdminComponent } from './avoir-vente/list/avoir-vente-list-admin.component';
import { AchatItemListAdminComponent } from './achat-item/list/achat-item-list-admin.component';
import { AchatListAdminComponent } from './achat/list/achat-list-admin.component';
import { AvoirAchatItemListAdminComponent } from './avoir-achat-item/list/avoir-achat-item-list-admin.component';
import { SortieProduitItemListAdminComponent } from './sortie-produit-item/list/sortie-produit-item-list-admin.component';
import { ProduitListAdminComponent } from './produit/list/produit-list-admin.component';
import { VenteItemListAdminComponent } from './vente-item/list/vente-item-list-admin.component';
import { TauxTvaListAdminComponent } from './taux-tva/list/taux-tva-list-admin.component';
import { AvoirAchatListAdminComponent } from './avoir-achat/list/avoir-achat-list-admin.component';
import { InventaireListAdminComponent } from './inventaire/list/inventaire-list-admin.component';
import { CommandeItemListAdminComponent } from './commande-item/list/commande-item-list-admin.component';
import { VenteListAdminComponent } from './vente/list/vente-list-admin.component';
import { CommandeListAdminComponent } from './commande/list/commande-list-admin.component';
import { StockListAdminComponent } from './stock/list/stock-list-admin.component';
import { EntreeProduitItemListAdminComponent } from './entree-produit-item/list/entree-produit-item-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'avoir-vente-item',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirVenteItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'achat-item',
                            children: [
                                {
                                    path: 'list',
                                    component: AchatItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'achat',
                            children: [
                                {
                                    path: 'list',
                                    component: AchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'avoir-achat-item',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirAchatItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'sortie-produit-item',
                            children: [
                                {
                                    path: 'list',
                                    component: SortieProduitItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'produit',
                            children: [
                                {
                                    path: 'list',
                                    component: ProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'vente-item',
                            children: [
                                {
                                    path: 'list',
                                    component: VenteItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'taux-tva',
                            children: [
                                {
                                    path: 'list',
                                    component: TauxTvaListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'inventaire',
                            children: [
                                {
                                    path: 'list',
                                    component: InventaireListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'commande-item',
                            children: [
                                {
                                    path: 'list',
                                    component: CommandeItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'vente',
                            children: [
                                {
                                    path: 'list',
                                    component: VenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'commande',
                            children: [
                                {
                                    path: 'list',
                                    component: CommandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'stock',
                            children: [
                                {
                                    path: 'list',
                                    component: StockListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'entree-produit-item',
                            children: [
                                {
                                    path: 'list',
                                    component: EntreeProduitItemListAdminComponent ,
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
export class StockAdminRoutingModule { }
