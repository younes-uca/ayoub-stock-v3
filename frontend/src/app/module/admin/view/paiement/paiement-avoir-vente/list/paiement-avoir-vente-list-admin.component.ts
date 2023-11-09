import {Component, OnInit} from '@angular/core';
import {PaiementAvoirVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementAvoirVenteAdmin.service';
import {PaiementAvoirVenteDto} from 'src/app/controller/model/paiement/PaiementAvoirVente.model';
import {PaiementAvoirVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';


@Component({
  selector: 'app-paiement-avoir-vente-list-admin',
  templateUrl: './paiement-avoir-vente-list-admin.component.html'
})
export class PaiementAvoirVenteListAdminComponent extends AbstractListController<PaiementAvoirVenteDto, PaiementAvoirVenteCriteria, PaiementAvoirVenteAdminService>  implements OnInit {

    fileName = 'PaiementAvoirVente';

    ventes: Array<VenteDto>;
    modePaiements: Array<ModePaiementDto>;
    avoirVentes: Array<AvoirVenteDto>;


    constructor( private paiementAvoirVenteService: PaiementAvoirVenteAdminService  , private modePaiementService: ModePaiementAdminService, private venteService: VenteAdminService, private avoirVenteService: AvoirVenteAdminService) {
        super(paiementAvoirVenteService);
        this.pdfName = 'PaiementAvoirVente.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadVente();
        this.loadModePaiement();
        this.loadAvoirVente();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.id', header: 'Vente'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'avoirVente?.id', header: 'Avoir vente'},
        ];
    }


    public async loadVente(){
       this.venteService.findAll().subscribe(ventes => this.ventes = ventes, error => console.log(error))
    }
    public async loadModePaiement(){
       this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements, error => console.log(error))
    }
    public async loadAvoirVente(){
       this.avoirVenteService.findAll().subscribe(avoirVentes => this.avoirVentes = avoirVentes, error => console.log(error))
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
                'Avoir vente': e.avoirVente?.id ,
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
        //'Avoir vente': this.criteria.avoirVente?.id ? this.criteria.avoirVente?.id : environment.emptyForExport ,
        }];
      }
}
