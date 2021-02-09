<template>
  <div class='demo-app'>
    <notifications animation-type="velocity" />
    <div class='demo-app-main'>
      <FullCalendar
        class='demo-app-calendar'
        :options='calendarOptions'>
        <template v-slot:eventContent="arg">
          <b>{{ arg.timeText }}</b>
          <i>{{ arg.event.title }}</i>
          <br/>
        </template>
      </FullCalendar>
    </div>
    <div>
        <b-modal ref="my-modal" hide-footer title="Informacije o pregledu">
      <b-row>
      <h4>_______________{{this.pharmacyName}}_______________ </h4>  
      </b-row>  
      <b-row>
        <b-col>
          <b-form inline>
              <b-form-input v-model="name"
                id="inline-form-input-name"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Jane Doe"
              ></b-form-input>
          </b-form>
        </b-col>  
         <b-col>
          <b-form inline>
              <b-form-input
              v-model="surname"
                id="inline-form-input-name"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Jane Doe"
              ></b-form-input>
          </b-form>
        </b-col>  
      </b-row>
      <b-row>
        <b-col>
          <b-form inline>
              <b-form-input  v-model="startDate"
                id="inline-form-input-name"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Jane Doe"
              ></b-form-input>
          </b-form>
        </b-col>  
         <b-col>
          <b-form inline>
              <b-form-input  v-model="endDate"
                id="inline-form-input-name"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Jane Doe"
              ></b-form-input>
          </b-form>
        </b-col>  
        <b-col>
         <b-button class="mt-3" variant="outline-danger" block @click="hideModal">Nazad</b-button>
        </b-col>
         <b-col>
         <b-button class="mt-3" variant="outline-danger" block @click="hideModal">Pregledaj</b-button>
        </b-col>
      </b-row>
    </b-modal>
    </div>
  </div>
</template>

<script>
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'

export default {

  components: {
    FullCalendar // make the <FullCalendar> tag available
  },

  data: function() {
    return {
      calendarOptions: {
        plugins: [
          dayGridPlugin,
          timeGridPlugin,
          interactionPlugin // needed for dateClick
        ],
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialView: 'dayGridMonth',
        editable: false,
        selectable: true,
        selectMirror: true,
        dayMaxEvents: true,
        weekends: true,
        select: this.handleDateSelect,
        eventClick: this.handleEventClick,
        eventsSet: this.handleEvents,
        events:this.examinations,
        /* you can update a remote database when these fire:
        eventAdd:
        eventChange:
        eventRemove:
        */
      },
      examinations : [],
      currentEvents: [],
      name :'',
      surname : '',
      pharmacyName: '',
      startDate:'',
      endDate :'',
      definedExaminations : []
    }
  },created() {
    // GET request for examination information
    this.$axios
      .get("http://localhost:9001/examination/examinaitonForCalendar/")
      .then((response) => {
        this.definedExaminations = response.data;
        let examinationsForCalendar = []
        for(let i in response.data){
          let ex = response.data[i]
          let startDate = new Date(ex.start)
          let endDate = new Date(startDate.getTime()+ 30*60000)
          let newEvent = {  id: ex.id,
                      title: ex.pharmacyName,
                      start: new Date(ex.start),
                      end : endDate,
                      backgroundColor : "#ff0000",
                      startStr : ex.name,
                      endStr : ex.surname
                      }
           examinationsForCalendar.push(newEvent)
        }
        this.examinations = examinationsForCalendar
        this.calendarOptions.events = examinationsForCalendar
      })
      .catch((error) => {
        this.errorMessage = error.message;
        console.error("There was an error!", error);
         this.$notify({
              type: "success",
              title: "Success",
              text: this.message,
              closeOnClick: true,
            });
      });
  },

  methods: {

    handleWeekendsToggle() {
      this.calendarOptions.weekends = !this.calendarOptions.weekends // update a property
    },

    handleDateSelect(selectInfo) {
      //let title = prompt('Please enter a new title for your event')
      let calendarApi = selectInfo.view.calendar

      calendarApi.unselect() // clear date selection

      // if (title) {
      //   calendarApi.addEvent({
      //     id: createEventId(),
      //     title,
      //     start: selectInfo.startStr,
      //     end: selectInfo.endStr,
      //     allDay: selectInfo.allDay
      //   })
      // }
    },

    handleEventClick(clickInfo) {
       this.$refs['my-modal'].show()
       console.log(clickInfo)
       let exam = this.definedExaminations.filter(obj => {return obj.id == clickInfo.event.id})
       this.pharmacyName = exam[0].pharmacyName
       this.name = exam[0].patientName
       this.surname = exam[0].patientSurname
       this.startDate = new Date(exam[0].start)
       this.endDate = new Date(this.startDate.getTime()+ 30*60000)
      // if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
      //   clickInfo.event.remove()
      // }
    },

    handleEvents(events) {
      this.currentEvents = events
    }
  }
}
</script>



<style lang='css'>

h2 {
  margin: 0;
  font-size: 16px;
}

ul {
  margin: 0;
  padding: 0 0 0 1.5em;
}

li {
  margin: 1.5em 0;
  padding: 0;
}

b { /* used for event dates/times */
  margin-right: 3px;
}

.demo-app {
  display: flex;
  min-height: 100%;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}

.demo-app-sidebar {
  width: 300px;
  line-height: 1.5;
  background: #eaf9ff;
  border-right: 1px solid #d3e2e8;
}

.demo-app-sidebar-section {
  padding: 2em;
}

.demo-app-main {
  flex-grow: 1;
  padding: 3em;
}

.fc { /* the calendar root */
  max-width: 1100px;
  margin: 0 auto;
}

</style>
