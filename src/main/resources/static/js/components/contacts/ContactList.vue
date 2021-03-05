<template>
    <div style="position: relative; width: 300px;">
        <contact-form :contacts="contacts" :contactAttr="contact" />
        <contact-row v-for="contact in contacts"
                     :key="contact.id"
                     :contact="contact"
                     :editContact="editContact"
                     :deleteContact="deleteContact"
                     :contacts="contacts" />
    </div>
</template>

<script>
    import ContactRow from 'components/contacts/ContactRow.vue'
    import ContactForm from 'components/contacts/ContactForm.vue'

    export default {
        props: ['contacts'],
        components: {
            ContactRow,
            ContactForm
        },
        data() {
            return {
                contact: null
            }
        },
        methods: {
            editContact(contact) {
                this.contact = contact
            },
            deleteContact(contact) {
                this.$resource('/contact{/id}').remove({id: contact.id}).then(result => {
                    if (result.ok) {
                        this.contacts.splice(this.contacts.indexOf(contact), 1)
                    }
                })
            }
        }
    }
</script>

<style>

</style>
