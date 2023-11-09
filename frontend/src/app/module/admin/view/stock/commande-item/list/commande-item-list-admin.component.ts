import {Component, OnInit} from '@angular/core';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemCriteria} from 'src/app/controller/criteria/stock/CommandeItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';


@Component({
  selector: 'app-commande-item-list-admin',
  templateUrl: './commande-item-list-admin.component.html'
})
export class CommandeItemListAdminComponent extends AbstractListController<CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService>  implements OnInit {

    fileName = 'CommandeItem';

    produits: Array<ProduitDto>;
    commandes: Array<CommandeDto>;


    constructor( private commandeItemService: CommandeItemAdminService  , private produitService: ProduitAdminService, private commandeService: CommandeAdminService) {
        super(commandeItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadCommande();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'commande?.id', header: 'Commande'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadCommande(){
       this.commandeService.findAll().subscribe(commandes => this.commandes = commandes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                'Commande': e.commande?.id ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Commande': this.criteria.commande?.id ? this.criteria.commande?.id : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
