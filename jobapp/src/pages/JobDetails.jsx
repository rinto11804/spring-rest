import React from 'react';
import '../styles/JobDetails.css';

const JobDetails = () => {
  // Sample job data in your specified format
  const job = {
    id: 10,
    postProfile: "Cloud Architect",
    postDescription: "We are looking for an experienced Cloud Architect to design and implement cloud solutions for our enterprise clients. You will be responsible for creating scalable, secure, and cost-effective cloud infrastructure while working closely with our engineering teams.",
    reqExperience: 7,
    techStack: ["AWS", "Azure", "GCP", "Microservices", "Serverless", "Kubernetes", "Terraform"],
    location: "Remote (Global)",
    salary: "$120,000 - $160,000",
    employmentType: "Full-time",
    postedDate: "2023-11-15",
    responsibilities: [
      "Design and implement cloud infrastructure solutions",
      "Develop architecture blueprints and documentation",
      "Optimize cloud costs and performance",
      "Ensure security and compliance standards",
      "Mentor junior team members"
    ],
    requirements: [
      "Bachelor's degree in Computer Science or related field",
      "7+ years of cloud architecture experience",
      "Certifications in AWS/Azure/GCP",
      "Strong knowledge of infrastructure as code",
      "Excellent problem-solving skills"
    ]
  };

  return (
    <div className="job-details-container">
      <div className="job-header">
        <h1 className="job-title">{job.postProfile}</h1>
        <div className="job-meta">
          <span className="job-location">{job.location}</span>
          <span className="job-salary">{job.salary}</span>
          <span className="job-type">{job.employmentType}</span>
        </div>
      </div>

      <div className="job-content">
        <section className="job-section">
          <h2>Job Description</h2>
          <p className="job-description">{job.postDescription}</p>
        </section>

        <section className="job-section">
          <h2>Responsibilities</h2>
          <ul className="job-list">
            {job.responsibilities.map((item, index) => (
              <li key={index}>{item}</li>
            ))}
          </ul>
        </section>

        <section className="job-section">
          <h2>Requirements</h2>
          <ul className="job-list">
            {job.requirements.map((item, index) => (
              <li key={index}>{item}</li>
            ))}
          </ul>
        </section>

        <section className="job-section">
          <h2>Technical Stack</h2>
          <div className="tech-stack">
            {job.techStack.map((tech, index) => (
              <span key={index} className="tech-item">{tech}</span>
            ))}
          </div>
        </section>

        <div className="job-actions">
          <button className="apply-button">Apply Now</button>
          <button className="save-button">Save Job</button>
        </div>
      </div>
    </div>
  );
};

export default JobDetails;