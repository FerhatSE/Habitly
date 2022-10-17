import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../services/auth.service";
import {AlertService} from "../../services/alert.service";
import {first} from "rxjs/operators";
import {faUser, faEnvelope, faLock, faCircleCheck} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['../login/login.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  confirmPassword = false;
  returnUrl: string;
  faUser = faUser;
  faEnvelope = faEnvelope;
  faLock = faLock;
  faCircleCheck = faCircleCheck;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService
  ) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      displayName: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  getFormFields() {
    return this.registerForm.controls;
  }

  onSubmit() {
    const formData = this.getFormFields();

    this.submitted = true;

    // reset alerts on submit
    this.alertService.clear();

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // stop if password and confirm password differ
    this.confirmPassword = this.validatePasswordConfirm();
    if (!this.confirmPassword) {
      return;
    }

    this.loading = true;

    this.authenticationService.register(
      formData["username"].value, formData["displayName"].value, formData["password"].value)
      .pipe(first())
      .subscribe(
        () => {
          void this.router.navigate([this.returnUrl]);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }

  validatePasswordConfirm() {
    const formData = this.getFormFields();
    return formData['password'].value == formData['confirmPassword'].value;
  }
}


