import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import PatientProfile from "../views/patient/profile/Profile.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
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
    path: "/patients",
    name: "myPatients",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/dermatologistAndPharmacist/MyPatients.vue")
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
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
