import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';

import { AppComponent } from 'src/app/app.component';
import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { RoleService } from 'src/app/zynerator/security/Role.service';
import {AppMainComponent} from 'src/app/template/app.main.component';

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html',
  animations: [
    trigger('inline', [
      state(
        'hidden',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visible',
        style({
          height: '*',
        })
      ),
      state(
        'hiddenAnimated',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visibleAnimated',
        style({
          height: '*',
        })
      ),
      transition(
        'visibleAnimated => hiddenAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
      transition(
        'hiddenAnimated => visibleAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
    ]),
  ],
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelanonymous: any[];
    modelAdmin: any[];
  constructor(public app: AppComponent, public appMain: AppMainComponent, private roleService: RoleService, private authService:AuthService, private router: Router) {}

  ngOnInit() {
    this.modelAdmin =
      [
              {
                label: 'Entree Produit',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste entree produit',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/entree/entree-produit/list']
                          },
                          {
                            label: 'Liste sortie produit',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/entree/sortie-produit/list']
                          },
                ]
              },
              {
                label: 'Entreprise/Societe',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste entreprise societe',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/entreprise-societe/list']
                          },
                ]
              },
              {
                label: 'PermutationItem',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste permutation item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/permutation-item/list']
                          },
                ]
              },
              {
                label: 'AvoirVenteItem',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste avoir vente item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/avoir-vente-item/list']
                          },
                ]
              },
              {
                label: 'Compte',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste compte',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/compte/list']
                          },
                ]
              },
              {
                label: 'AchatItem',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste achat item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/achat-item/list']
                          },
                ]
              },
              {
                label: 'Proprietaire',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste proprietaire',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/proprietaire/list']
                          },
                ]
              },
              {
                label: 'Paiement Achat',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste paiement achat',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/paiement/paiement-achat/list']
                          },
                ]
              },
              {
                label: 'Possede Compte',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste possede compte',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/possede-compte/list']
                          },
                ]
              },
              {
                label: 'VenteItem',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste vente item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/vente-item/list']
                          },
                ]
              },
              {
                label: 'Product',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste stock',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/stock/list']
                          },
                ]
              },
              {
                label: 'AvoirAchatItem',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste avoir achat item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/avoir-achat-item/list']
                          },
                ]
              },
              {
                label: 'Produit',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste produit',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/produit/list']
                          },
                ]
              },
              {
                label: 'Fournisseur',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste fournisseur',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/fournisseur/list']
                          },
                ]
              },
              {
                label: 'Paiement Avoir Vente',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste paiement avoir vente',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/paiement/paiement-avoir-vente/list']
                          },
                ]
              },
              {
                label: 'Banque',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste type transaction',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/type-transaction/list']
                          },
                          {
                            label: 'Liste banque',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/banque/list']
                          },
                ]
              },
              {
                label: 'AvoirVente',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste avoir vente',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/avoir-vente/list']
                          },
                ]
              },
              {
                label: 'AvoirAchat',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste avoir achat',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/avoir-achat/list']
                          },
                ]
              },
              {
                label: 'Proprietaire Banque',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste proprietaire banque',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/proprietaire-banque/list']
                          },
                ]
              },
              {
                label: 'Vente',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste taux tva',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/taux-tva/list']
                          },
                          {
                            label: 'Liste vente',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/vente/list']
                          },
                ]
              },
              {
                label: 'Achat',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste achat',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/achat/list']
                          },
                ]
              },
              {
                label: 'Type Instrument',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste type instrument',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/type-instrument/list']
                          },
                ]
              },
              {
                label: 'Client',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste client',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/client/list']
                          },
                ]
              },
              {
                label: 'Divers',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste collaborateur',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/collaborateur/list']
                          },
                          {
                            label: 'Liste mode paiement',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/mode-paiement/list']
                          },
                          {
                            label: 'Liste categorie',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/categorie/list']
                          },
                          {
                            label: 'Liste depot',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/depot/list']
                          },
                          {
                            label: 'Liste ville',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/ville/list']
                          },
                          {
                            label: 'Liste unite mesure',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/unite-mesure/list']
                          },
                          {
                            label: 'Liste etat commande',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/etat-commande/list']
                          },
                          {
                            label: 'Liste etat achat',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/etat-achat/list']
                          },
                          {
                            label: 'Liste marque',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/marque/list']
                          },
                          {
                            label: 'Liste etat vente',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/commun/etat-vente/list']
                          },
                ]
              },
              {
                label: 'Cheque/Effet',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste cheque effet',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/cheque-effet/list']
                          },
                ]
              },
              {
                label: 'Permutation',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste permutation',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/permutation/list']
                          },
                ]
              },
              {
                label: 'Paiement Avoir Achat',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste paiement avoir achat',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/paiement/paiement-avoir-achat/list']
                          },
                ]
              },
              {
                label: 'Commande',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste commande',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/commande/list']
                          },
                ]
              },
              {
                label: 'Inventaire',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste inventaire',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/inventaire/list']
                          },
                ]
              },
              {
                label: 'Commande Item',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste sortie produit item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/sortie-produit-item/list']
                          },
                          {
                            label: 'Liste commande item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/commande-item/list']
                          },
                          {
                            label: 'Liste entree produit item',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/stock/entree-produit-item/list']
                          },
                ]
              },
              {
                label: 'Paiement Vente',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste paiement vente',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/paiement/paiement-vente/list']
                          },
                ]
              },
              {
                label: 'Depense',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste depense',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/depense/depense/list']
                          },
                ]
              },
              {
                label: 'Transaction',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste transaction',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/gestionchequeffet/transaction/list']
                          },
                ]
              },
              {
                label: 'Instrument',
                icon: 'pi pi-wallet',
                items: [
                          {
                            label: 'Liste instrument',
                            icon: 'pi pi-fw pi-plus-circle',
                            routerLink: ['/app/admin/chequeffet/instrument/list']
                          },
                ]
              },
    ];
        if (this.authService.authenticated) {
            if (this.authService.authenticatedUser.roles) {
              this.authService.authenticatedUser.roles.forEach(role => {
                  const roleName: string = this.getRole(role);
                  this.roleService._role.next(roleName.toUpperCase());
                  eval('this.model = this.model' + this.getRole(role));
              })
            }
        }
  }

    getRole(text){
        const [role, ...rest] = text.split('_');
        return this.upperCaseFirstLetter(rest.join(''));
    }

    upperCaseFirstLetter(word: string) {
      if (!word) { return word; }
      return word[0].toUpperCase() + word.substr(1).toLowerCase();
    }

    onMenuClick(event) {
        this.appMain.onMenuClick(event);
    }
}
