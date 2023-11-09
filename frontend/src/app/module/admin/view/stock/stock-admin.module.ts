import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';

import { AvoirVenteItemCreateAdminComponent } from './avoir-vente-item/create/avoir-vente-item-create-admin.component';
import { AvoirVenteItemEditAdminComponent } from './avoir-vente-item/edit/avoir-vente-item-edit-admin.component';
import { AvoirVenteItemViewAdminComponent } from './avoir-vente-item/view/avoir-vente-item-view-admin.component';
import { AvoirVenteItemListAdminComponent } from './avoir-vente-item/list/avoir-vente-item-list-admin.component';
import { AvoirVenteCreateAdminComponent } from './avoir-vente/create/avoir-vente-create-admin.component';
import { AvoirVenteEditAdminComponent } from './avoir-vente/edit/avoir-vente-edit-admin.component';
import { AvoirVenteViewAdminComponent } from './avoir-vente/view/avoir-vente-view-admin.component';
import { AvoirVenteListAdminComponent } from './avoir-vente/list/avoir-vente-list-admin.component';
import { AchatItemCreateAdminComponent } from './achat-item/create/achat-item-create-admin.component';
import { AchatItemEditAdminComponent } from './achat-item/edit/achat-item-edit-admin.component';
import { AchatItemViewAdminComponent } from './achat-item/view/achat-item-view-admin.component';
import { AchatItemListAdminComponent } from './achat-item/list/achat-item-list-admin.component';
import { AchatCreateAdminComponent } from './achat/create/achat-create-admin.component';
import { AchatEditAdminComponent } from './achat/edit/achat-edit-admin.component';
import { AchatViewAdminComponent } from './achat/view/achat-view-admin.component';
import { AchatListAdminComponent } from './achat/list/achat-list-admin.component';
import { AvoirAchatItemCreateAdminComponent } from './avoir-achat-item/create/avoir-achat-item-create-admin.component';
import { AvoirAchatItemEditAdminComponent } from './avoir-achat-item/edit/avoir-achat-item-edit-admin.component';
import { AvoirAchatItemViewAdminComponent } from './avoir-achat-item/view/avoir-achat-item-view-admin.component';
import { AvoirAchatItemListAdminComponent } from './avoir-achat-item/list/avoir-achat-item-list-admin.component';
import { SortieProduitItemCreateAdminComponent } from './sortie-produit-item/create/sortie-produit-item-create-admin.component';
import { SortieProduitItemEditAdminComponent } from './sortie-produit-item/edit/sortie-produit-item-edit-admin.component';
import { SortieProduitItemViewAdminComponent } from './sortie-produit-item/view/sortie-produit-item-view-admin.component';
import { SortieProduitItemListAdminComponent } from './sortie-produit-item/list/sortie-produit-item-list-admin.component';
import { ProduitCreateAdminComponent } from './produit/create/produit-create-admin.component';
import { ProduitEditAdminComponent } from './produit/edit/produit-edit-admin.component';
import { ProduitViewAdminComponent } from './produit/view/produit-view-admin.component';
import { ProduitListAdminComponent } from './produit/list/produit-list-admin.component';
import { VenteItemCreateAdminComponent } from './vente-item/create/vente-item-create-admin.component';
import { VenteItemEditAdminComponent } from './vente-item/edit/vente-item-edit-admin.component';
import { VenteItemViewAdminComponent } from './vente-item/view/vente-item-view-admin.component';
import { VenteItemListAdminComponent } from './vente-item/list/vente-item-list-admin.component';
import { TauxTvaCreateAdminComponent } from './taux-tva/create/taux-tva-create-admin.component';
import { TauxTvaEditAdminComponent } from './taux-tva/edit/taux-tva-edit-admin.component';
import { TauxTvaViewAdminComponent } from './taux-tva/view/taux-tva-view-admin.component';
import { TauxTvaListAdminComponent } from './taux-tva/list/taux-tva-list-admin.component';
import { AvoirAchatCreateAdminComponent } from './avoir-achat/create/avoir-achat-create-admin.component';
import { AvoirAchatEditAdminComponent } from './avoir-achat/edit/avoir-achat-edit-admin.component';
import { AvoirAchatViewAdminComponent } from './avoir-achat/view/avoir-achat-view-admin.component';
import { AvoirAchatListAdminComponent } from './avoir-achat/list/avoir-achat-list-admin.component';
import { InventaireCreateAdminComponent } from './inventaire/create/inventaire-create-admin.component';
import { InventaireEditAdminComponent } from './inventaire/edit/inventaire-edit-admin.component';
import { InventaireViewAdminComponent } from './inventaire/view/inventaire-view-admin.component';
import { InventaireListAdminComponent } from './inventaire/list/inventaire-list-admin.component';
import { CommandeItemCreateAdminComponent } from './commande-item/create/commande-item-create-admin.component';
import { CommandeItemEditAdminComponent } from './commande-item/edit/commande-item-edit-admin.component';
import { CommandeItemViewAdminComponent } from './commande-item/view/commande-item-view-admin.component';
import { CommandeItemListAdminComponent } from './commande-item/list/commande-item-list-admin.component';
import { VenteCreateAdminComponent } from './vente/create/vente-create-admin.component';
import { VenteEditAdminComponent } from './vente/edit/vente-edit-admin.component';
import { VenteViewAdminComponent } from './vente/view/vente-view-admin.component';
import { VenteListAdminComponent } from './vente/list/vente-list-admin.component';
import { CommandeCreateAdminComponent } from './commande/create/commande-create-admin.component';
import { CommandeEditAdminComponent } from './commande/edit/commande-edit-admin.component';
import { CommandeViewAdminComponent } from './commande/view/commande-view-admin.component';
import { CommandeListAdminComponent } from './commande/list/commande-list-admin.component';
import { StockCreateAdminComponent } from './stock/create/stock-create-admin.component';
import { StockEditAdminComponent } from './stock/edit/stock-edit-admin.component';
import { StockViewAdminComponent } from './stock/view/stock-view-admin.component';
import { StockListAdminComponent } from './stock/list/stock-list-admin.component';
import { EntreeProduitItemCreateAdminComponent } from './entree-produit-item/create/entree-produit-item-create-admin.component';
import { EntreeProduitItemEditAdminComponent } from './entree-produit-item/edit/entree-produit-item-edit-admin.component';
import { EntreeProduitItemViewAdminComponent } from './entree-produit-item/view/entree-produit-item-view-admin.component';
import { EntreeProduitItemListAdminComponent } from './entree-produit-item/list/entree-produit-item-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    AvoirVenteItemCreateAdminComponent,
    AvoirVenteItemListAdminComponent,
    AvoirVenteItemViewAdminComponent,
    AvoirVenteItemEditAdminComponent,
    AvoirVenteCreateAdminComponent,
    AvoirVenteListAdminComponent,
    AvoirVenteViewAdminComponent,
    AvoirVenteEditAdminComponent,
    AchatItemCreateAdminComponent,
    AchatItemListAdminComponent,
    AchatItemViewAdminComponent,
    AchatItemEditAdminComponent,
    AchatCreateAdminComponent,
    AchatListAdminComponent,
    AchatViewAdminComponent,
    AchatEditAdminComponent,
    AvoirAchatItemCreateAdminComponent,
    AvoirAchatItemListAdminComponent,
    AvoirAchatItemViewAdminComponent,
    AvoirAchatItemEditAdminComponent,
    SortieProduitItemCreateAdminComponent,
    SortieProduitItemListAdminComponent,
    SortieProduitItemViewAdminComponent,
    SortieProduitItemEditAdminComponent,
    ProduitCreateAdminComponent,
    ProduitListAdminComponent,
    ProduitViewAdminComponent,
    ProduitEditAdminComponent,
    VenteItemCreateAdminComponent,
    VenteItemListAdminComponent,
    VenteItemViewAdminComponent,
    VenteItemEditAdminComponent,
    TauxTvaCreateAdminComponent,
    TauxTvaListAdminComponent,
    TauxTvaViewAdminComponent,
    TauxTvaEditAdminComponent,
    AvoirAchatCreateAdminComponent,
    AvoirAchatListAdminComponent,
    AvoirAchatViewAdminComponent,
    AvoirAchatEditAdminComponent,
    InventaireCreateAdminComponent,
    InventaireListAdminComponent,
    InventaireViewAdminComponent,
    InventaireEditAdminComponent,
    CommandeItemCreateAdminComponent,
    CommandeItemListAdminComponent,
    CommandeItemViewAdminComponent,
    CommandeItemEditAdminComponent,
    VenteCreateAdminComponent,
    VenteListAdminComponent,
    VenteViewAdminComponent,
    VenteEditAdminComponent,
    CommandeCreateAdminComponent,
    CommandeListAdminComponent,
    CommandeViewAdminComponent,
    CommandeEditAdminComponent,
    StockCreateAdminComponent,
    StockListAdminComponent,
    StockViewAdminComponent,
    StockEditAdminComponent,
    EntreeProduitItemCreateAdminComponent,
    EntreeProduitItemListAdminComponent,
    EntreeProduitItemViewAdminComponent,
    EntreeProduitItemEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,

  ],
  exports: [
  AvoirVenteItemCreateAdminComponent,
  AvoirVenteItemListAdminComponent,
  AvoirVenteItemViewAdminComponent,
  AvoirVenteItemEditAdminComponent,
  AvoirVenteCreateAdminComponent,
  AvoirVenteListAdminComponent,
  AvoirVenteViewAdminComponent,
  AvoirVenteEditAdminComponent,
  AchatItemCreateAdminComponent,
  AchatItemListAdminComponent,
  AchatItemViewAdminComponent,
  AchatItemEditAdminComponent,
  AchatCreateAdminComponent,
  AchatListAdminComponent,
  AchatViewAdminComponent,
  AchatEditAdminComponent,
  AvoirAchatItemCreateAdminComponent,
  AvoirAchatItemListAdminComponent,
  AvoirAchatItemViewAdminComponent,
  AvoirAchatItemEditAdminComponent,
  SortieProduitItemCreateAdminComponent,
  SortieProduitItemListAdminComponent,
  SortieProduitItemViewAdminComponent,
  SortieProduitItemEditAdminComponent,
  ProduitCreateAdminComponent,
  ProduitListAdminComponent,
  ProduitViewAdminComponent,
  ProduitEditAdminComponent,
  VenteItemCreateAdminComponent,
  VenteItemListAdminComponent,
  VenteItemViewAdminComponent,
  VenteItemEditAdminComponent,
  TauxTvaCreateAdminComponent,
  TauxTvaListAdminComponent,
  TauxTvaViewAdminComponent,
  TauxTvaEditAdminComponent,
  AvoirAchatCreateAdminComponent,
  AvoirAchatListAdminComponent,
  AvoirAchatViewAdminComponent,
  AvoirAchatEditAdminComponent,
  InventaireCreateAdminComponent,
  InventaireListAdminComponent,
  InventaireViewAdminComponent,
  InventaireEditAdminComponent,
  CommandeItemCreateAdminComponent,
  CommandeItemListAdminComponent,
  CommandeItemViewAdminComponent,
  CommandeItemEditAdminComponent,
  VenteCreateAdminComponent,
  VenteListAdminComponent,
  VenteViewAdminComponent,
  VenteEditAdminComponent,
  CommandeCreateAdminComponent,
  CommandeListAdminComponent,
  CommandeViewAdminComponent,
  CommandeEditAdminComponent,
  StockCreateAdminComponent,
  StockListAdminComponent,
  StockViewAdminComponent,
  StockEditAdminComponent,
  EntreeProduitItemCreateAdminComponent,
  EntreeProduitItemListAdminComponent,
  EntreeProduitItemViewAdminComponent,
  EntreeProduitItemEditAdminComponent,
  ],
  entryComponents: [],
})
export class StockAdminModule { }
