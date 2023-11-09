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

import { PaiementAvoirAchatCreateAdminComponent } from './paiement-avoir-achat/create/paiement-avoir-achat-create-admin.component';
import { PaiementAvoirAchatEditAdminComponent } from './paiement-avoir-achat/edit/paiement-avoir-achat-edit-admin.component';
import { PaiementAvoirAchatViewAdminComponent } from './paiement-avoir-achat/view/paiement-avoir-achat-view-admin.component';
import { PaiementAvoirAchatListAdminComponent } from './paiement-avoir-achat/list/paiement-avoir-achat-list-admin.component';
import { PaiementAvoirVenteCreateAdminComponent } from './paiement-avoir-vente/create/paiement-avoir-vente-create-admin.component';
import { PaiementAvoirVenteEditAdminComponent } from './paiement-avoir-vente/edit/paiement-avoir-vente-edit-admin.component';
import { PaiementAvoirVenteViewAdminComponent } from './paiement-avoir-vente/view/paiement-avoir-vente-view-admin.component';
import { PaiementAvoirVenteListAdminComponent } from './paiement-avoir-vente/list/paiement-avoir-vente-list-admin.component';
import { PaiementVenteCreateAdminComponent } from './paiement-vente/create/paiement-vente-create-admin.component';
import { PaiementVenteEditAdminComponent } from './paiement-vente/edit/paiement-vente-edit-admin.component';
import { PaiementVenteViewAdminComponent } from './paiement-vente/view/paiement-vente-view-admin.component';
import { PaiementVenteListAdminComponent } from './paiement-vente/list/paiement-vente-list-admin.component';
import { PaiementAchatCreateAdminComponent } from './paiement-achat/create/paiement-achat-create-admin.component';
import { PaiementAchatEditAdminComponent } from './paiement-achat/edit/paiement-achat-edit-admin.component';
import { PaiementAchatViewAdminComponent } from './paiement-achat/view/paiement-achat-view-admin.component';
import { PaiementAchatListAdminComponent } from './paiement-achat/list/paiement-achat-list-admin.component';

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

    PaiementAvoirAchatCreateAdminComponent,
    PaiementAvoirAchatListAdminComponent,
    PaiementAvoirAchatViewAdminComponent,
    PaiementAvoirAchatEditAdminComponent,
    PaiementAvoirVenteCreateAdminComponent,
    PaiementAvoirVenteListAdminComponent,
    PaiementAvoirVenteViewAdminComponent,
    PaiementAvoirVenteEditAdminComponent,
    PaiementVenteCreateAdminComponent,
    PaiementVenteListAdminComponent,
    PaiementVenteViewAdminComponent,
    PaiementVenteEditAdminComponent,
    PaiementAchatCreateAdminComponent,
    PaiementAchatListAdminComponent,
    PaiementAchatViewAdminComponent,
    PaiementAchatEditAdminComponent,
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
  PaiementAvoirAchatCreateAdminComponent,
  PaiementAvoirAchatListAdminComponent,
  PaiementAvoirAchatViewAdminComponent,
  PaiementAvoirAchatEditAdminComponent,
  PaiementAvoirVenteCreateAdminComponent,
  PaiementAvoirVenteListAdminComponent,
  PaiementAvoirVenteViewAdminComponent,
  PaiementAvoirVenteEditAdminComponent,
  PaiementVenteCreateAdminComponent,
  PaiementVenteListAdminComponent,
  PaiementVenteViewAdminComponent,
  PaiementVenteEditAdminComponent,
  PaiementAchatCreateAdminComponent,
  PaiementAchatListAdminComponent,
  PaiementAchatViewAdminComponent,
  PaiementAchatEditAdminComponent,
  ],
  entryComponents: [],
})
export class PaiementAdminModule { }
