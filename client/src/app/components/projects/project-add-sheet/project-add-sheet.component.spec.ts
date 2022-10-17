import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectAddSheetComponent } from './project-add-sheet.component';

describe('ProjectAddSheetComponent', () => {
  let component: ProjectAddSheetComponent;
  let fixture: ComponentFixture<ProjectAddSheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectAddSheetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjectAddSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
