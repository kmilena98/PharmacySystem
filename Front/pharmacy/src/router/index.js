import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import PatientProfile from "../views/patient/profile/Profile.vue";
import Registration from "../views/registration/Registration.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/registration",
    name: "Registration",
    component: Registration
  },
  {
    path: "/patient-profile",
    name: "Patient Profile",
    component: PatientProfile
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path: "/myPatients",
    name: "myPatients",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/dermatologistAndPharmacist/MyPatients.vue")
  }, {
    path: "/searchedPatients",
    name: "searchedPatients",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/dermatologistAndPharmacist/SearchedPatients.vue")
  },
  {
    path: "/examination",
    name: "startExamination",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/dermatologistAndPharmacist/StartExamination.vue")
  },
  {
    path: "/newExamination",
    name: "newExamination",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/dermatologistAndPharmacist/NewExamination.vue")
  },
  {
    path: "/pharmacies",
    name: "Pharmacy",
    component: () =>
      import("../views/patient/pharmacy/Pharmacy.vue")
  },
  {
    path: "/pharmacy/:id/dermatologist-examinations",
    name: "DermatologisExaminations",
    component: () =>
      import("../views/pharmacy/DermatologistExaminations.vue")
  },

  {
    path: "/systemAdminsPage",
    name: "System admins Page",
    component: () =>
      import("../views/systemAdmin/users/SystemAdminsPage.vue")
  },
  {
    path: "/pharmacyAdminsPage",
    name: "Pharmacy admins Page",
    component: () =>
      import("../views/systemAdmin/users/PharmacyAdminsPage.vue")
  },
  {
    path: "/dermatologistsPage",
    name: "Dermatologists Page",
    component: () =>
      import("../views/systemAdmin/users/DermatologistsPage.vue")
  },
  {
    path: "/suppliersPage",
    name: "Suppliers Page",
    component: () =>
      import("../views/systemAdmin/users/SuppliersPage.vue")
  },
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
