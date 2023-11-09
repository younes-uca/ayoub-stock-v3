import {Component, OnInit} from '@angular/core';
import {PaiementVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementVenteAdmin.service';
import {PaiementVenteDto} from 'src/app/controller/model/paiement/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';


@Component({
  selector: 'app-paiement-vente-list-admin',
  templateUrl: './paiement-vente-list-admin.component.html'
})
export class PaiementVenteListAdminComponent extends AbstractListController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteAdminService>  implements OnInit {

    fileName = 'PaiementVente';

    ventes: Array<VenteDto>;
    modePaiements: Array<ModePaiementDto>;


    constructor( private paiementVenteService: PaiementVenteAdminService  , private modePaiementService: ModePaiementAdminService, private venteService: VenteAdminService) {
        super(paiementVenteService);
        this.pdfName = 'PaiementVente.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadVente();
        this.loadModePaiement();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.id', header: 'Vente'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
        ];
    }


    public async loadVente(){
       this.venteService.findAll().subscribe(ventes => this.ventes = ventes, error => console.log(error))
    }
    public async loadModePaiement(){
       this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Vente': e.vente?.id ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.id ? this.criteria.vente?.id : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
