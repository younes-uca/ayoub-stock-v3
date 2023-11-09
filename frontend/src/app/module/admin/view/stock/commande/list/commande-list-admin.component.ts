import {Component, OnInit} from '@angular/core';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/stock/CommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';


@Component({
  selector: 'app-commande-list-admin',
  templateUrl: './commande-list-admin.component.html'
})
export class CommandeListAdminComponent extends AbstractListController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    fileName = 'Commande';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    fournisseurs: Array<FournisseurDto>;
    etatCommandes: Array<EtatCommandeDto>;


    constructor( private commandeService: CommandeAdminService  , private etatCommandeService: EtatCommandeAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private commandeItemService: CommandeItemAdminService, private fournisseurService: FournisseurAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadFournisseur();
        this.loadEtatCommande();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'fournisseur?.ice', header: 'Fournisseur'},
            {field: 'etatCommande?.libelle', header: 'Etat commande'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }
    public async loadEtatCommande(){
       this.etatCommandeService.findAllOptimized().subscribe(etatCommandes => this.etatCommandes = etatCommandes, error => console.log(error))
    }

	public initDuplicate(res: CommandeDto) {
        if (res.commandeItems != null) {
             res.commandeItems.forEach(d => { d.commande = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                'Fournisseur': e.fournisseur?.ice ,
                'Etat commande': e.etatCommande?.libelle ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.ice ? this.criteria.fournisseur?.ice : environment.emptyForExport ,
        //'Etat commande': this.criteria.etatCommande?.libelle ? this.criteria.etatCommande?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
